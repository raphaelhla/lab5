package saga;

import easyaccept.EasyAccept;

public class Main {

	public static void main(String[] args) {
		args = new String[] { "saga.Facade", "TestesAceitacao/use_case_1.txt", "TestesAceitacao/use_case_2.txt", "TestesAceitacao/use_case_3.txt"};
		EasyAccept.main(args);
	}
}
