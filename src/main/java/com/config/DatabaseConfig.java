package com.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
//Right now we are not able accepting pageable request,but when we start accepting this will come in handy
@EnableSpringDataWebSupport
public class DatabaseConfig {

	@Value("${db.driver}")
	private String DB_DRIVER;

	@Value("${db.password}")
	private String DB_PASSWORD;

	@Value("${db.url}")
	private String DB_URL;

	@Value("${db.username}")
	private String DB_USERNAME;

	// kamailio db
	// @Value("${db.driver1}")
	// private String DB_DRIVER1;
	// @Value("${db.password1}")
//	private String DB_PASSWORD1;

	// @Value("${db.url1}")
	// private String DB_URL1;

	// @Value("${db.username1}")
	// private String DB_USERNAME1;
	@Value("${hibernate.c3p0.max_size1}")
	private String hibernatec3p0max_size1;

	@Value("${hibernate.dialect}")
	private String HIBERNATE_DIALECT;

	@Value("${hibernate.show_sql}")
	private String HIBERNATE_SHOW_SQL;

	@Value("${hibernate.enable_lazy_load_no_trans}")
	private String enable_lazy_load_no_trans;

	@Value("${hibernate.hbm2ddl.auto}")
	private String HIBERNATE_HBM2DDL_AUTO;

	@Value("${hibernate.c3p0.min_size}")
	private String hibernatec3p0min_size;

	@Value("${hibernate.c3p0.max_size}")
	private String hibernatec3p0max_size;

	@Value("${hibernate.c3p0.timeout}")
	private String hibernatec3p0timeout;

	@Value("${hibernate.c3p0.max_statements}")
	private String hibernatec3p0max_statements;

	@Value("${hibernate.c3p0.idle_test_period}")
	private String hibernatec3p0idle_test_period;

	@Value("${entitymanager.packagesToScan}")
	private String ENTITYMANAGER_PACKAGES_TO_SCAN;

	/*
	 * @Bean public DataSource dataSource() { BasicDataSource dataSource = new
	 * BasicDataSource(); dataSource.setDriverClassName(DB_DRIVER);
	 * dataSource.setUrl(DB_URL); dataSource.setUsername(DB_USERNAME);
	 * dataSource.setPassword(DB_PASSWORD); return dataSource; }
	 */

	@Bean
	@Primary
	public ComboPooledDataSource dataSource() {
		// a named datasource is best practice for later jmx monitoring
		ComboPooledDataSource dataSource = new ComboPooledDataSource("jupiter");

		try {
			dataSource.setDriverClass(DB_DRIVER);
		} catch (PropertyVetoException pve) {
			System.out.println("Cannot load datasource driver (" + DB_DRIVER + ") : " + pve.getMessage());
			return null;
		}
		dataSource.setJdbcUrl(DB_URL);
		dataSource.setUser(DB_USERNAME);
		dataSource.setPassword(DB_PASSWORD);
		dataSource.setMinPoolSize(Integer.parseInt(hibernatec3p0min_size));
		dataSource.setMaxPoolSize(Integer.parseInt(hibernatec3p0max_size));
		dataSource.setMaxIdleTime(Integer.parseInt(hibernatec3p0idle_test_period));
		dataSource.setAcquireIncrement(1);
		dataSource.setAutoCommitOnClose(true);
		dataSource.setUnreturnedConnectionTimeout(120);
		dataSource.setDebugUnreturnedConnectionStackTraces(true);
		// dataSource.setCheckoutTimeout(300);

		return dataSource;
	}

	@Bean
	@Primary
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
		hibernateProperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
		hibernateProperties.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
		hibernateProperties.put("hibernate.enable_lazy_load_no_trans", enable_lazy_load_no_trans);
		hibernateProperties.put(Environment.AUTOCOMMIT, true);
		// create connection per thread
		hibernateProperties.put("current_session_context_class", "thread");

		hibernateProperties.put("Hibernate.temp.use_jdbc_metadata_defaults", false);

		sessionFactoryBean.setHibernateProperties(hibernateProperties);
		return sessionFactoryBean;
	}

	/*
	 * @Bean
	 * 
	 * @Qualifier("kamailiodataSource") public ComboPooledDataSource
	 * kamailiodataSource() { // a named datasource is best practice for later jmx
	 * monitoring ComboPooledDataSource dataSource = new
	 * ComboPooledDataSource("jupiter");
	 * 
	 * try { dataSource.setDriverClass(DB_DRIVER1); } catch (PropertyVetoException
	 * pve) { System.out.println("Cannot load datasource driver (" + DB_DRIVER1 +
	 * ") : " + pve.getMessage()); return null; } dataSource.setJdbcUrl(DB_URL1);
	 * dataSource.setUser(DB_USERNAME1); dataSource.setPassword(DB_PASSWORD1);
	 * dataSource.setMinPoolSize(Integer.parseInt(hibernatec3p0min_size));
	 * dataSource.setMaxPoolSize(Integer.parseInt(hibernatec3p0max_size1));
	 * dataSource.setMaxIdleTime(Integer.parseInt(hibernatec3p0idle_test_period));
	 * dataSource.setAcquireIncrement(1); dataSource.setAutoCommitOnClose(true);
	 * dataSource.setUnreturnedConnectionTimeout(120);
	 * dataSource.setDebugUnreturnedConnectionStackTraces(true); //
	 * dataSource.setCheckoutTimeout(300);
	 * 
	 * return dataSource; }
	 */

	/*
	 * @Bean
	 * 
	 * @Qualifier("kamailiosessionFactory") public LocalSessionFactoryBean
	 * kamailiosessionFactory() { LocalSessionFactoryBean kamailiosessionFactoryBean
	 * = new LocalSessionFactoryBean();
	 * kamailiosessionFactoryBean.setDataSource(kamailiodataSource());
	 * kamailiosessionFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
	 * Properties hibernateProperties = new Properties();
	 * hibernateProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
	 * hibernateProperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
	 * hibernateProperties.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
	 * hibernateProperties.put("hibernate.enable_lazy_load_no_trans",
	 * enable_lazy_load_no_trans); hibernateProperties.put(Environment.AUTOCOMMIT,
	 * true); // create connection per thread
	 * hibernateProperties.put("current_session_context_class", "thread");
	 * 
	 * hibernateProperties.put("Hibernate.temp.use_jdbc_metadata_defaults", false);
	 * 
	 * kamailiosessionFactoryBean.setHibernateProperties(hibernateProperties);
	 * return kamailiosessionFactoryBean; }
	 */

	@Bean
	@Primary
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		transactionManager.setDefaultTimeout(400);
		return transactionManager;
	}

	@Bean
	@Qualifier("transactionManager2")
	public JpaTransactionManager transactionManager2() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		transactionManager.setDefaultTimeout(400);
		return transactionManager;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		em.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
		em.setPersistenceUnitName("name");
		return em;
	}

	/*
	 * @Bean
	 * 
	 * @Qualifier("kamailiotransactionManager") public HibernateTransactionManager
	 * kamailiotransactionManager() { HibernateTransactionManager transactionManager
	 * = new HibernateTransactionManager();
	 * transactionManager.setSessionFactory(kamailiosessionFactory().getObject());
	 * // transactionManager.setHibernateManagedSession(true);
	 * transactionManager.setDefaultTimeout(60); return transactionManager; }
	 */

} // class DatabaseConfig
