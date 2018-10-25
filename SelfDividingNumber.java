
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SelfDividingNumber {

	public static void main(String[] args) throws Exception {
		int left = 1;
		int right = 1000;

		System.out.println(selfDividingNumbers(left, right));
	}

	public static List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> digitsList;

		for (int number = left; number <= right; number++) {
			// Find digits in the number
			digitsList = getDigits(number);
			if (digitsList != null) {
				if (isSelfDivisible(number, digitsList))
					list.add(number);
			}
		}

		return list;
	}

	private static Set<Integer> getDigits(int number) {
		Set<Integer> list = null;

		if (number > 0) {
			list = new HashSet<Integer>();

			int remainder;

			while (number > 0) {
				remainder = number % 10;

				if (remainder > 0) {
					if (remainder != 1)
						list.add(remainder);

					number /= 10;
				}
				else
					return null;
			}
		}

		return list;
	}

	private static  boolean isSelfDivisible(int number, Set<Integer> digitsList) {
		if (number > 0 && digitsList != null && digitsList.size() > 0) {
			for (Integer digit : digitsList) {
				if (number % digit != 0)
					return false;
			}
		}

		return true;
	}

}
