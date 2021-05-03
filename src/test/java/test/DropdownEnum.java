package test;

public enum DropdownEnum {

	INDEX {
		@Override
		public String toString()
		{
			return "index";
		}
	},
	
	VALUE {
		@Override
		public String toString()
		{
			return "value";
		}
	},
	
	VISIBLETEXT {
		@Override
		public String toString()
		{
			return "visibleText";
		}
	}

}
