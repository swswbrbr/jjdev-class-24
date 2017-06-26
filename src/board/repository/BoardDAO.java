package board.repository;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.model.Board;

public class BoardDAO {
	private SqlSessionFactory getSqlSessionFactory(){
		String resource = "config.xml";
		InputStream inputstream = null;
		try {
			inputstream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		return sqlSessionFactory;
	}
	
	public Board selectBoard(int No){
		SqlSession sqlSession
		= this.getSqlSessionFactory().openSession();
		return sqlSession.selectOne("board.repository.BoardMapper.selectBoard", No);
	}
}
	
