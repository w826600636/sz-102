package C3P0Utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class C3P0Utils {
        //创建连接池自动读取配置文件
        private static DataSource dataSource = new ComboPooledDataSource();

        /**
         * 提供Connection
         * @return
         * @throws Exception
         */
        public static Connection getConnection() throws Exception {
                Connection connection = dataSource.getConnection();
                return connection;
        }

        /**
         * 释放资源
         *
         * @param resultSet
         * @param statement
         * @param connection
         * @throws Exception
         */
        public static void closeAll(ResultSet resultSet, Statement statement, Connection connection) throws Exception {
                if (resultSet != null) {
                        resultSet.close();
                }

                if (statement != null) {
                        statement.close();
                }
                if (connection != null) {
                        connection.close();
                }

        }


}

