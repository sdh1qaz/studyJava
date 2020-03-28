package 集合;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

public class CollectionUtilsTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		System.out.println(CollectionUtils.isEmpty(list));
	}
}
