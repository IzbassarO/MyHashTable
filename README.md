# MyHashTable
This project is a simple implementation of a HashTable data structure in Java.
HashTable is a data structure that allows quick insertion, deletion, and retrieval of key-value pairs.

The main class, MyHashTable, contains methods for inserting (put), retrieving (get), and removing (remove) key-value pairs.
The keys and values can be of any type that implements the hashCode and equals methods.

The MyHashTable class uses chaining to handle collisions, meaning that if two keys hash to the same index,
their corresponding values are stored in a linked list at that index.

To test the functionality of the HashTable, the Main class generates 10,000 random key-value pairs
and inserts them into the HashTable. It then prints out the number of elements in each bucket to show
how the chaining strategy handles collisions.

MyHashTable class:
Overall, 10 methods contained
remove type: void. It make the the given key place be removed and size is decresed by 1.
clear type: void. It make all indexes of a chainArray equals to null.
put type: void. It added an element to the chainArray and size is incremented.
getKey type: K. returns the key is it found thought interation in while condition, but if it is not found
returns null
hash type: int. It returns return Math.abs(key.hashCode() % chainArray.length);
expandTable type: void. It expands the size of the chainArray
get type: V. returns the value is it found thought interation in while condition, but if it is not found
returns null
containsKey type: boolean. It has identical function as get by checking by while condition if chainArray consists of the given array it returns true, otherwise, false.
getChainArray type: ListNode<K, V>[]. Returns the chainArray.
size type: int. It returns the private variable size that goes through each methods as remove or put, expandTable. Returns the current size of chainArray.

Main class:
created table object of MyHashTable with key&value: Testing, MobilePhone
table iterated 10000 times and had various elements
Also, used different methods as put, get, remove, and clear, size
