MyBatis逆向工程生成mapper.xml、Mapper借口、以及实体（Example）

1、添加jar依赖
2、配置插件
    <build>
        <plugins>
            <plugin>
                <groupId>org.mybatis.generator</groupId>
                <artifactId>mybatis-generator-maven-plugin</artifactId>
                <version>1.3.3</version>
                <configuration>
                    <configurationFile>${project.basedir}/src/main/resources/mybatis/generatorConfig.xml</configurationFile>
                </configuration>
            </plugin>
        </plugins>
    </build>

3、配置generatorConfig.xml配置文件
    <context> 标签中的次级标签需要有一定的顺序