/**
 *    Copyright 2006-2016 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.wave.base.plugin.mybatis.generator;
 
import java.util.List;
import java.util.Properties;

import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.config.PropertyRegistry;

/**
 * This plugin adds the Example SuperClass marker interface to all generated
 * model objects.
 * <p>
 * This plugin demonstrates adding capabilities to generated Java artifacts, and
 * shows the proper way to add imports to a compilation unit.
 * <p>
 * Important: This is a simplistic implementation of SuperClass and does not
 * attempt to do any versioning of classes.
 * 
 * @author Jeff Butler
 * 
 */
public class BaseExampleModelPlugin extends PluginAdapter {

   

    public BaseExampleModelPlugin() {
        super();
    }

    public boolean validate(List<String> warnings) {
        // this plugin is always valid
        return true;
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
    }
    
    
    @Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		this.makeExampleSuperClass(topLevelClass,introspectedTable);
		return true;
	}

	private FullyQualifiedJavaType getSuperClass(IntrospectedTable introspectedTable) {
        FullyQualifiedJavaType superClass;
        String rootClass = getRootClass(introspectedTable);
        if (rootClass != null) {
            superClass = new FullyQualifiedJavaType(rootClass);
        } else {
            superClass = null;
        }

        return superClass;
    }
    
    public String getRootClass(IntrospectedTable introspectedTable) {
        String rootClass = introspectedTable
                .getTableConfigurationProperty(PropertyRegistry.ANY_ROOT_CLASS);
        if (rootClass == null) {
            Properties properties = context.getJavaModelGeneratorConfiguration().getProperties();
            rootClass = properties.getProperty(PropertyRegistry.ANY_ROOT_CLASS);
        }

        return rootClass;
    }
    
    protected void makeExampleSuperClass(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
        
    	  FullyQualifiedJavaType superClass = getSuperClass(introspectedTable);
          if (superClass != null) {
              topLevelClass.setSuperClass(superClass);
              topLevelClass.addImportedType(superClass);
              context.getCommentGenerator().addModelClassComment(topLevelClass, introspectedTable); 
          }

        }
  
}
