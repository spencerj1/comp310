package edu.wit.comp310.lab2;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.wit.comp310.lab1.MyLinkedList;

public class MyLinkedListMap<Key extends Comparable<Key>,Value> implements Map<Key,Value>{
	List<Pair<Key, Value>> list = new MyLinkedList<Pair<Key, Value>>();
	
	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		for (Pair<Key,Value> item : list) {
			if (item.key.equals(key)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsValue(Object arg0) {
		for (Pair<Key,Value> item : list) {
			if (item.value.equals(arg0)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Set<java.util.Map.Entry<Key, Value>> entrySet() {
		Set<java.util.Map.Entry<Key, Value>> result = new HashSet<java.util.Map.Entry<Key, Value>>();
		for (Pair<Key, Value> item : list) {
			result.add(item);
		}
		return result;
	}

	@Override
	public Value get(Object arg0) {
		if(containsKey(arg0)){
			for (Pair<Key, Value> item : list){
				if (item.key.equals(arg0)){
					return item.value;
				}
			}
		}
			
		
		return null;
	}

	@Override
	public boolean isEmpty() {
		return list.size() == 0;
	}

	@Override
	public Set<Key> keySet() {
		Set<Key> Kset = new HashSet<Key>();
		for (Pair<Key,Value> item : list) {
				Kset.add(item.key);
		}
		return Kset;
	}

	@Override
	public Value put(Key arg0, Value arg1) {
		Pair<Key, Value> item = new Pair<Key, Value>(arg0, arg1);
		if (!(containsKey(arg0))){
		list.add(item);
		}
		else {
			
		}
		return null;
	}

	@Override
	public void putAll(Map<? extends Key, ? extends Value> arg0) {
		for (java.util.Map.Entry<? extends Key,? extends Value> entry : arg0.entrySet() ){
			put(entry.getKey(), entry.getValue());
			
		}
		
	}

	@Override
	public Value remove(Object arg0) {
		Value temp = null;
		if (containsKey(arg0)){
			for (Pair<Key, Value> item : list){
				if (item.key.equals(arg0)){
					temp = item.value;
					list.remove(item);
				}
			}
		}
		return temp;
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public Collection<Value> values() {
		Collection<Value> Vset = new HashSet<Value>();
		for (Pair<Key,Value> item : list) {
				Vset.add(item.value);
		}
		return Vset;
		
	}
	
}
