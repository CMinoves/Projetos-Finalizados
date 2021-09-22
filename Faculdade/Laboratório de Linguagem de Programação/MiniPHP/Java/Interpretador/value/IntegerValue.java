package Interpretador.value;

public class IntegerValue extends PrimitiveValue<Integer> {

	private Integer value;

	public IntegerValue(Integer value) {
	  this.value = value;
	}

	public Integer value() {
	  return value;
	}
  }

