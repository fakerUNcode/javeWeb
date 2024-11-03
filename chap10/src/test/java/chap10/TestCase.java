package chap10;

import util.DBUtil;

import java.sql.Connection;

import org.junit.Test;

public class TestCase {

	@Test
	public void test() {
		Connection con = DBUtil.getConnection();
		System.out.println(con);
	}

}
