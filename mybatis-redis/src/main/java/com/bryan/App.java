package com.bryan;

import java.lang.reflect.Method;

public class App {

    final String t1="t1";
    final String t2="t2";
    String t4="t4";
    String t3=t4+t2;

    static class Stoke{
        public String getStoke(String name,int num){
            return name+":"+num;
        }
    }

    public static void main(String[] args) throws Exception {
        Method getStoke = Stoke.class.getMethod("getStoke", String.class, int.class);
        String name=getStoke.getName();
        Class<?>[] parameterTypes = getStoke.getParameterTypes();
        Object[] objs=new Object[]{"hello",2};
//        JSONObject jsonObject=new JSONObject();
//        jsonObject.put("name",name);
//        jsonObject.put("types",parameterTypes);
//        jsonObject.put("args",objs);
//
//        String s = jsonObject.toJSONString();
//        System.out.println(s);
//
//        JSONObject jsonObject1 = JSON.parseObject(s);
//        JSONArray types = jsonObject1.getJSONArray("types");
//       Class[] cls= (Class[]) types.toArray();



//        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("e:/oos"));
//       oos.writeUTF(name);
//       oos.writeObject(parameterTypes);
//       oos.writeObject(objs);
//       oos.flush();
//
//
//        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("e:/oos"));
//        String a1 = ois.readUTF();
//       Class[] clss=(Class[]) ois.readObject();
//       Object[] objs1=(Object[]) ois.readObject();








    }
}
