package cn.enixlin.jmrc.asone.manager.util;

import java.io.FileReader;
import java.io.IOException;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavascriptEngine {
	
	public JavascriptEngine(){
		
	}
	
	/**
	 * 在java环境里运行javascript代码
	 * @param jsFile
	 * @param jsFunctionName
	 * @param args
	 * @return
	 * @throws ScriptException
	 * @throws NoSuchMethodException
	 * @throws IOException
	 */
	public Object jsRun(String jsFile,String jsFunctionName,Object[] args) throws ScriptException, NoSuchMethodException, IOException{
		ScriptEngineManager manager = new ScriptEngineManager();   
		ScriptEngine engine = manager.getEngineByName("javascript");     

		String jsFileName = jsFile; // 读取js文件   

		FileReader reader = new FileReader(jsFileName);   
		engine.eval(reader);   // 执行指定脚本   

		Object result = null;
		if(engine instanceof Invocable) {    
		Invocable invoke = (Invocable)engine;       

		// c = merge(2, 3);    

		result = (String)invoke.invokeFunction(jsFunctionName,args);  // 调用js里的方法，并传入参数   

		System.out.println("Result is = " + result);   
		}   

		reader.close();  
		return result;

	}
	

}
