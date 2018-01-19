package com.feicuiedu.ATM.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DelUser {

	
	
	public void du() {
		//构建Scanner,输入身份证号跟账号
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要删除的用户身份证号跟账号:");
		String index = scanner.nextLine();
		
		
		File file = new File("User.txt");
		try {
			//读取User文件中的ArrayList<Map>集合放入d_list中
			FileInputStream fis = new FileInputStream(file); 
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			ArrayList<Map> d_list = new ArrayList<>();
			
			for (Map map : d_list) {
				
				Set<String> keys = map.keySet();
				
				//ArrayList<User> userList = null;
				
				for (String key : keys) {
					
					if(key.equals(index)) {
						d_list.remove(map);
						
						FileOutputStream fos = new FileOutputStream(file);
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						
						oos.writeObject(d_list);
						oos.flush();
						oos.close();
						
					}else {
						
					}
					
				}
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
