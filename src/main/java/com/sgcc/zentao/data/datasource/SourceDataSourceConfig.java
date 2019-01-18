
package com.sgcc.zentao.data.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * <b>概述</b>： <blockquote>源数据库配置</blockquote>
 * <p/>
 * <b>功能</b>： <blockquote>请补充</blockquote>
 * 
 * @author <a href="mailto:1284676837@qq.com">唐亮</a>
 **/
@Configuration
@MapperScan(basePackages = "com.sgcc.zentao.data.mapper.source",
        sqlSessionTemplateRef = "sourceSqlSessionTemplate")
public class SourceDataSourceConfig {
    /**  
     * driverName: 数据库连接驱动  
     *  
     */
    @Value("${spring.datasource.source.driverClassName}")
    private String driverName;
    /**  
     * url:数据库链接
     *  
     */
    @Value("${spring.datasource.url}")
    private String url;
    /**
     * hosted:数据库地址
     */
    @Value("${spring.datasource.source.url}")
    private String hosted;
    /**  
     * username:用户名
     *  
     */
    @Value("${spring.datasource.source.username}")
    private String username;
    /**  
     * password:密码
     *  
     */
    @Value("${spring.datasource.source.password}")
    private String password;
    /**  
     * mapperLocation: mybatis xml 配置路径
     *  
     */
    @Value("${spring.datasource.source.mapper}")
    private String mapperLocation;
    
    /**
     * Alias
     */
    @Value("${mybatis.typeAliasesPackage}")
    private String aliasLoaction;
    

    @Bean(name="sourceDataSource")
    @Primary
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url.replace("{url}", hosted));
        dataSource.setDriverClassName(driverName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
    
    @Bean(name="sourceSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("sourceDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocation));
        bean.setTypeAliasesPackage(aliasLoaction);
        return bean.getObject();
    }
    
    @Bean(name="sourceSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sourceSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
