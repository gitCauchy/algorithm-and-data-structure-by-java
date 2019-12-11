package com.cauchy.tree.huffmantree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCode {
	public static void main(String[] args) {
		String message = "can you can a can as a canner can a can";
		byte[] bytes = message.getBytes();
		byte[] b = huffmanZip(bytes);
		// �������
		byte[] newByte = decode(huffCodes,b);
		String meg = new String(newByte);
	}
	
	private static byte[] decode(Map<Byte, String> huffCodes, byte[] bytes) {
		// ��byte����ת��һ�������Ƶ��ַ���
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < bytes.length; i ++) {
			byte b = bytes[i];
			boolean flag = (i == bytes.length - 1);
			sb.append(byteToBitStr(!flag, b));
		}
		// ���ַ�������ָ���ĺշ���������н���
		// �Ѻշ��������ֵ����
		Map<String,Byte> map = new HashMap();
		for(Map.Entry<Byte, String> entry : huffCodes.entrySet()) {
			map.put(entry.getValue(), entry.getKey());
		}
		
		// ����һ�����ϣ����ڴ�byte
		List<Byte> list = new ArrayList();
		// �����ַ���
		for(int i = 0; i < sb.length();) {
			int count = i;
			boolean flag = true;
			Byte b = null;
			while(flag) {
				String key = sb.substring(i, i + count);
				b = map.get(key);
				if(b == null) {
					count ++;
				}else {
					flag = false;
				}
			}
			list.add(b);
			i += count;
		}
		byte[] b = new byte[list.size()];
		for(int i = 0;i < b.length; i ++) {
			b[i] = list.get(i);
		}
		return b;
	}

	private static String byteToBitStr(boolean flag,byte b) {
		int temp = b;
		if(flag) {
			temp |= 256;
		}
		String str = Integer.toBinaryString(temp);
		if(flag) {
			return str.substring(str.length() - 8);
		}else {
			return str;
		}
	}
	private static byte[] huffmanZip(byte[] bytes) {
		// ��ͳ��ÿ��byte���ֵĴ����������뵽һ��������
		List<CodeNode> nodes = getNodes(bytes);
		// ����һ���շ�����
		CodeNode tree = createHuffmanTree(nodes);
		// ����һ���շ��������
		Map<Byte,String> huffmanCodes = getCodes(tree);
		// ����
		byte[] b = zip(bytes,huffCodes);
		return b;
		
	}
	private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes) {
		StringBuilder sb = new StringBuilder();
		for(byte b:bytes) {
			sb.append(huffCodes.get(b));
		}
		int length;
		if(sb.length() % 8 == 0) {
			length = sb.length() / 8;
		}else {
			length = sb.length() / 8 + 1;
		}
		// ���ڴ洢ѹ�����byte
		byte[] by = new byte[length];
		int index = 0;
		for(int i = 0; i < sb.length(); i += 8) {
			String strByte;
			if( i + 8 > sb.length()) {
				strByte = sb.substring(i);
			}
			strByte = sb.substring(i, i + 8);
			byte byt = (byte) Integer.parseInt(strByte);
			by[index] = byt;
			index ++;
		}
		return by;
	}
	// ��ʱ�洢·��
	static StringBuilder sb = new StringBuilder();
	// ��ʱ�洢�շ�������
	static Map<Byte,String> huffCodes = new HashMap<Byte,String>();
	private static Map<Byte, String> getCodes(CodeNode tree) {
		if(tree == null) {
			return null;
		}
		getCodes(tree.lNode,"0",sb);
		getCodes(tree.rNode,"1",sb);
		return huffCodes;
	}

	private static void getCodes(CodeNode node, String code, StringBuilder sb) {
		StringBuilder sb2 = new StringBuilder(sb);
		sb2.append(code);
		if(node.data == null) {
			getCodes(node.lNode,"0",sb2);
			getCodes(node.rNode,"1",sb2);
		}else {
			huffCodes.put(node.data, sb2.toString());
		}
	}

	private static CodeNode createHuffmanTree(List<CodeNode> nodes) {
		while(nodes.size() > 1) {
			Collections.sort(nodes);
			CodeNode left = nodes.get(nodes.size() - 1);
			CodeNode right = nodes.get(nodes.size() -2);
			CodeNode parent = new CodeNode(left.weight + right.weight,null);
			parent.lNode = left;
			parent.rNode = right;
			// ��������ɾ��
			nodes.remove(left);
			nodes.remove(right);
			nodes.add(parent);
		}
		return nodes.get(0);
	}

	private static List<CodeNode> getNodes(byte[] bytes) {
		List<CodeNode> nodes = new ArrayList<>();
		Map<Byte,Integer> counts = new HashMap<>();
		for(byte b : bytes) {
			Integer count = counts.get(b);
			if(counts.get(b) == 0) {
				counts.put(b, 1);
			}else {
				counts.put(b, count + 1);
			}
		}
		// ��ÿһ����ֵ��תΪnode����
		for(Map.Entry<Byte,Integer> entry : counts.entrySet()) {
			nodes.add(new CodeNode(entry.getValue(),entry.getKey()));
		}
		return nodes;
	}
	
	// �ļ�ѹ��
	// ----------------------------------------------------------------------
	public static void zipFile(String src,String dst) throws IOException {
		// ����һ��������
		InputStream is = new FileInputStream(src);
		// ����һ����������ָ���ļ���Сһ����byte����
		byte[] b = new byte[is.available()];
		// ��ȡ�ļ�����
		is.read(b);
		is.close();
		// ʹ�úշ����������ѹ��
		byte[] byteZip = huffmanZip(b);
		OutputStream out = new FileOutputStream(dst);
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(byteZip);
		oos.writeObject(huffCodes);
		oos.close();
		out.close();
	}
	
	public static void unZip(String src,String dst) throws IOException, ClassNotFoundException {
		// ����һ��������
		InputStream is = new FileInputStream(src);
		// ��ȡbyte����
		ObjectInputStream ois = new ObjectInputStream(is);
		byte[] b = (byte[]) ois.readObject();
		// ��ȡhuffman�����
		Map<Byte,String> code = (Map<Byte, String>) ois.readObject();
		ois.close();
		is.close();
		byte[] bytes = decode(code,b);
		OutputStream os = new FileOutputStream(dst);
		os.write(bytes);
		os.close();
	}
	
}
