package cn.java.db;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

public class JdbcUtil {
	private JdbcUtil(){}
	 //������BasicDataSource�����
		private static BasicDataSource datasource = new BasicDataSource();
		
		//��̬�����,����BasicDataSource�����е�����,�Զ���
		static{
			//���ݿ�������Ϣ,�����
			datasource.setDriverClassName("com.mysql.jdbc.Driver");
			datasource.setUrl("jdbc:mysql://localhost:3306/mybase");
			datasource.setUsername("root");
			datasource.setPassword("123456");
			//�������ӳ��е�������������,��ѡ��
			datasource.setInitialSize(10);//��ʼ����������
			datasource.setMaxActive(8);//�����������
			datasource.setMaxIdle(5);//��������
			datasource.setMinIdle(1);//��С����
		}
		
		
		//���徲̬����,����BasicDataSource��Ķ���
		public static DataSource getDataSource(){
			return datasource;
		}
	


}
