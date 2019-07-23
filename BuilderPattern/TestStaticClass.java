//Builder Pattern
//생성자에 매개변수로 때려넣는 것이 아니고, 체이닝 기법으로, 가독성있게 객체를 만들어주는 패턴.
//객체 일관성과 불변성을 지킬수도 있다고 한다.
public class TestStaticClass {
	private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // Required parameters(필수 인자)
        private final int servingSize;
        private final int servings;

        // Optional parameters - initialized to default values(선택적 인자는 기본값으로 초기화)
        private int calories      = 0;
        private int fat           = 0;
        private int carbohydrate  = 0;
        private int sodium        = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings    = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;    // 이렇게 하면 . 으로 체인을 이어갈 수 있다.
        }
        public Builder fat(int val) {
            fat = val;
            return this;
        }
        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }
        public Builder sodium(int val) {
            sodium = val;
            return this;
        }
        public TestStaticClass build() {
            return new TestStaticClass(this);
        }
    }

    private TestStaticClass(Builder builder) {
        servingSize  = builder.servingSize;
        servings     = builder.servings;
        calories     = builder.calories;
        fat          = builder.fat;
        sodium       = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
    
    @Override
	public String toString() {
		return "TestStaticClass [servingSize=" + servingSize + ", servings=" + servings + ", calories=" + calories
				+ ", fat=" + fat + ", sodium=" + sodium + ", carbohydrate=" + carbohydrate + "]";
	}

    //class안에 static이라는 게 무슨의미인지 전혀 모르겠다.
	public static void main(String[] args) {
    	TestStaticClass.Builder builder = new TestStaticClass.Builder(240, 8);
    	builder.calories(100);
    	builder.sodium(35);
    	builder.carbohydrate(27);
    	TestStaticClass cocaCola = builder.build();
    	System.out.println(cocaCola);
	}
}
