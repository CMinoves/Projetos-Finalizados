//Alunos>  Bruno Rocha Ribeiro & Cristhian Minoves
module choose_data(d0,d1,d2,d3,l0,l1,l2,l3,s); //Mux boladao para fazer a seleção de acordo com o hit de cada conjunto

input[8:0]d0,d1,d2,d3;

input l0,l1,l2,l3;

reg [3:0] control;

output reg [8:0]s;

always@(*)
    begin
	 control[0]=l0;
	 control[1]=l1;
	 control[2]=l2;
	 control[3]=l3;
        case(control)
            4'b0001: s = d0;
            4'b0010: s = d1;
            4'b0100: s = d2;
            4'b1000: s = d3;
        endcase
    end
endmodule

module parte3(input clock, input [2:0]dataIn, input [4:0]address, output hit, input write_enable, output reg via0, output reg via1, output reg via2, output reg via3, output reg [8:0]out_data);
	reg [8:0]cache0[0:3];
	reg [8:0]cache1[0:3];
	reg [8:0]cache2[0:3];
	reg [8:0]cache3[0:3];
	wire [1:0]index = address[1:0];
	wire bit_valid_cache0, bit_valid_cache1, bit_valid_cache2, bit_valid_cache3;
	wire LRU;
	wire dirty;
	wire [2:0]tag = address[4:2];	
	wire [2:0]tag_cache0;
	wire [2:0]tag_cache1;
	wire [2:0]tag_cache2;
	wire [2:0]tag_cache3;
	wire [2:0]dados_cache0;
   wire [2:0]dados_cache1;
	wire [2:0]dados_cache2;
   wire [2:0]dados_cache3;
	assign {bit_valid_cache0,LRU,dirty,tag_cache0,dados_cache0} = cache0[index], {bit_valid_cache1,LRU,dirty,tag_cache1,dados_cache1} = cache1[index],{bit_valid_cache2,LRU,dirty,tag_cache2,dados_cache2} = cache2[index],{bit_valid_cache3,LRU,dirty,tag_cache3,dados_cache3} = cache3[index];
   wire tag0 = (tag == tag_cache0); 
	wire tag1 = (tag == tag_cache1); 
	wire tag2 = (tag == tag_cache2); 
	wire tag3 = (tag == tag_cache3);  
	wire hit_cache0 = (tag0 & bit_valid_cache0); 
	wire hit_cache1 = (tag1 & bit_valid_cache1);  
	wire hit_cache2 = (tag2 & bit_valid_cache2); 
	wire hit_cache3 = (tag3 & bit_valid_cache3); 
	assign hit = hit_cache0 | hit_cache1 | hit_cache2 | hit_cache3;

	wire [8:0]data_mux;	
	choose_data mux_boladao(dados_cache0, dados_cache1, dados_cache2, dados_cache3, hit_cache0, hit_cache1, hit_cache2, hit_cache3, data_mux);
	//assign out_data = data_mux; 
	
	initial begin
		
		//Arquivo de TESTE da Prof
		cache0[0] <= 9'b110001001;
		cache0[1] <= 9'b000000000;
		cache0[2] <= 9'b000000000;
		cache0[3] <= 9'b000000000;
		
		cache1[0] <= 9'b110000010;
		cache1[1] <= 9'b110010110;
		cache1[2] <= 9'b000011000;
		cache1[3] <= 9'b000000000;
		
		cache2[0] <= 9'b110000101;
		cache2[1] <= 9'b000000000;
		cache2[2] <= 9'b000000000;
		cache2[3] <= 9'b000000000;
	
		cache3[0] <= 9'b000100000;
		cache3[1] <= 9'b000000000;
		cache3[2] <= 9'b000000000;
		cache3[3] <= 9'b000000000;
	end	
	
	always@(posedge clock) begin	
	out_data = data_mux; 
	//6 dirty ; 7 lru ; 8 validade
	
	 if(write_enable) begin
		if(hit_cache0) begin //write hit: escreve aonde bateu a tag
			cache0[index] <= {2'b11,tag,dataIn};
				cache1[index][7] <= 0;   
				cache2[index][7] <= 0;
				cache3[index][7] <= 0; 
		end
		if(hit_cache1) begin
			cache1[index] <= {2'b11,tag,dataIn};
			cache0[index][7] <= 0;   
			cache2[index][7] <= 0;
			cache3[index][7] <= 0; 
		end
		if(hit_cache2) begin
			cache2[index] <= {2'b11,tag,dataIn};
			cache1[index][7] <= 0;   
			cache0[index][7] <= 0;
			cache3[index][7] <= 0;	
		end
		if(hit_cache3) begin
			cache3[index] <= {2'b11,tag,dataIn};
			cache1[index][7] <= 0;   
			cache2[index][7] <= 0;
			cache0[index][7] <= 0;
		end
		else begin//ver depois o caso de write miss
			cache2[index] <= {2'b10,tag,dataIn};
			cache1[index][7] <= 1;	
		end
	end

	else
		if (~write_enable) begin 
			if(hit) begin//read hit: coloca o valor na saida e atualiza o lru
				if(hit_cache0) begin
				out_data <= cache0[index];
					cache0[index][7] <= 1; 
					cache1[index][7] <= 0;
					cache2[index][7] <= 0;
					cache3[index][7] <= 0;	
				end
				else if(hit_cache1) begin
				out_data <= cache1[index];
					cache0[index][7] <= 0; 
					cache1[index][7] <= 1;
					cache2[index][7] <= 0;
					cache3[index][7] <= 0;	
				end
				else if(hit_cache2) begin
				out_data <= cache2[index];
					cache0[index][7] <= 0;
					cache1[index][7] <= 0;
					cache2[index][7] <= 1;
					cache3[index][7] <= 0;	
				end
				else if(hit_cache3) begin
				out_data <= cache3[index];
					cache0[index][7] <= 0; 
					cache1[index][7] <= 0;
					cache2[index][7] <= 0;
					cache3[index][7] <= 1;	
				end
			end
			else begin//read miss: vê aonde bateu a tag, atualiza o valor dos dados e altera o lru
			if (~hit) begin
			if(tag0) begin
				if(index == 0) begin
					cache0[1][7] <= 0;
					cache0[index] <= {3'b110,tag,dataIn};
					cache0[2][7] <= 0;
					cache0[3][7] <= 0;
				end
				
				if(index == 1) begin
					cache0[0][7] <= 0;
					cache0[index] <= {3'b110,tag,dataIn};
					cache0[2][7] <= 0;
					cache0[3][7] <= 0;
				end
				
				if(index == 2) begin
					cache0[0][7] <= 0;
					cache0[index] <= {3'b110,tag,dataIn};
					cache0[1][7] <= 0;
					cache0[3][7] <= 0;
				end
				
				if(index == 3) begin
					cache0[0][7] <= 0;
					cache0[index] <= {3'b110,tag,dataIn};
					cache0[1][7] <= 0;
					cache0[2][7] <= 0;
				end
			end
			
			 if(tag1) begin	
				if(index == 0) begin
					cache1[1][7] <= 0;
					cache1[index] <= {3'b110,tag,dataIn};
					cache1[2][7] <= 0;
					cache1[3][7] <= 0;
				end
				
				if(index == 1) begin
					cache1[0][7] <= 0;
					cache1[index] <= {3'b110,tag,dataIn};
					cache1[2][7] <= 0;
					cache1[3][7] <= 0;
				end
				
				if(index == 2) begin
					cache1[0][7] <= 0;
					cache1[index] <= {3'b110,tag,dataIn};
					cache1[1][7] <= 0;
					cache1[3][7] <= 0;
				end
				
				if(index == 3) begin
					cache1[0][7] <= 0;
					cache1[index] <= {3'b110,tag,dataIn};
					cache1[1][7] <= 0;
					cache1[2][7] <= 0;
				end
			end
			
			
			if(tag2) begin 		
				if(index == 0) begin
					cache2[1][7] <= 0;
					cache2[index] <= {3'b110,tag,dataIn};
					cache2[2][7] <= 0;
					cache2[3][7] <= 0;
				end
				
				if(index == 1) begin
					cache2[0][7] <= 0;
					cache2[index] <= {3'b110,tag,dataIn};
					cache2[2][7] <= 0;
					cache2[3][7] <= 0;
				end
				
				if(index == 2) begin
					cache2[0][7] <= 0;
					cache2[index] <= {3'b110,tag,dataIn};
					cache2[1][7] <= 0;
					cache2[3][7] <= 0;
				end
				
				if(index == 3) begin
					cache2[0][7] <= 0;
					cache2[index] <= {3'b110,tag,dataIn};
					cache2[1][7] <= 0;
					cache2[2][7] <= 0;
				end
			end
			
			
			if(tag3) begin 		
				if(index == 0) begin
					cache3[1][7] <= 0;
					cache3[index] <= {3'b110,tag,dataIn};
					cache3[2][7] <= 0;
					cache3[3][7] <= 0;
				end
				
				if(index == 1) begin
					cache3[0][7] <= 0;
					cache3[index] <= {3'b110,tag,dataIn};
					cache3[2][7] <= 0;
					cache3[3][7] <= 0;
				end
				
				if(index == 2) begin
					cache3[0][7] <= 0;
					cache3[index] <= {3'b110,tag,dataIn};
					cache3[1][7] <= 0;
					cache3[3][7] <= 0;
				end
				
				if(index == 3) begin
					cache3[0][7] <= 0;
					cache3[index] <= {3'b110,tag,dataIn};
					cache3[1][7] <= 0;
					cache3[2][7] <= 0;
				end
			end
			
			end
				//out_data <= 9'b110011011; 
			end
		end 
	
	end

endmodule
