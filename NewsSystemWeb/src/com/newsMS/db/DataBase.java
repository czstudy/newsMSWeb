package com.newsMS.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.PropertyResourceBundle;

public class DataBase {
	private static String url;						//���ݿ������ִ�
	private static String userName;				//���ݿ��û�����
	private static String driver;					//���ݿ���������
	private static String pwd;						//���ݿ��û���½����
	private final static String fileName="database";	//�����ļ�����
		//ThreadLocal ��ǰ�ֲ߳̾�����
	@SuppressWarnings("rawtypes")
	private static ThreadLocal connection=new ThreadLocal();

		static{
			readConfig();
		}

		//	getConn�������ڻ�ȡ���ݿ�����
		/**
		 * synchronized ���ƶ����Ա�����ķ��ʣ�ÿ����ʵ����Ӧһ������
		 * ÿ�� synchronized �����������õ��ø÷�������ʵ����������ִ�У�
		 * ���������߳�����������һ��ִ�У��Ͷ�ռ������ֱ���Ӹ÷�������ʱ��
		 * �����ͷţ��˺��������̷߳��ܻ�ø��������½����ִ��״̬�����ֻ���
		 * ȷ����ͬһʱ�̶���ÿһ����ʵ��������������Ϊ synchronized �ĳ�Ա����
		 * ������ֻ��һ�����ڿ�ִ��״̬����Ϊ����ֻ��һ���ܹ���ø���ʵ����Ӧ��������
		 * �Ӷ���Ч���������Ա�����ķ��ʳ�ͻ
		 */ 
		@SuppressWarnings("unchecked")
		public synchronized static Connection getConn()throws SQLException{
			Connection con=(Connection) connection.get();
			if (con!=null && !con.isClosed()){
				return con;
			}
				try{
					@SuppressWarnings("unused")
					Class providerClass=Class.forName(driver);
					con=DriverManager.getConnection(url,userName,pwd);
					//setAutoCommit
					//�������ӵ��Զ��ύģʽ����Ϊ����״̬��������Ӵ����Զ��ύģʽ�£���ִ�������� SQL ��䣬������Щ�����Ϊ�����������ύ��
					//������ SQL ��佫����ؽ���ͨ������ commit ������ rollback ������ֹ�������С�Ĭ������£��µ����Ӵ����Զ��ύģʽ�¡� 
					con.setAutoCommit(false);
					connection.set(con);
					return con;
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				return null;
		}

		//��ȡ�����ļ���Ϣ
		@SuppressWarnings("unchecked")
		private static void readConfig(){
			//PropertyResourceBundleʹ�������ļ��еľ�̬�ַ����������������Ի�����Դ��
			PropertyResourceBundle prb=(PropertyResourceBundle) PropertyResourceBundle
				.getBundle(fileName);
			//ö��Enumeration
			Enumeration enu=prb.getKeys();
			while (enu.hasMoreElements()){
				String propertyName=enu.nextElement().toString();
			//��ȡ�����ļ��еľ�̬�ַ������Ҹ�ֵ�����Ա����
				if (propertyName.equals("database.driver"))
					driver=prb.getString("database.driver");
				if (propertyName.equals("database.url"))
					url=prb.getString("database.url");
				if (propertyName.equals("database.username"))
					userName=prb.getString("database.username");
				if (propertyName.equals("database.password"))
					pwd=prb.getString("database.password");
			}
		}
			
		//	commit ʹ�Դ���һ���ύ/�ع��������е����и��ĳ�Ϊ�־ø��ģ����ͷŴ� Connection ����ǰ������������ݿ�������
		//  �˷���Ӧ��ֻ���ѽ����Զ��ύģʽʱʹ�á� 
		public static void commit(){
			Connection con=(Connection) connection.get();
			try{
				con.commit();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		//�ع�����
		public static void rollback(){
			Connection con=(Connection) connection.get();
			try{
				con.rollback() ;
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		//�ͷ����ݿ�����
		public synchronized static void releaseConnection(Connection connection){
			try{
				if (connection!= null && !connection.isClosed())
					connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			connection=null;
		}
		
		public static void main(String[] args){
			try{
				DataBase.getConn();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
}
