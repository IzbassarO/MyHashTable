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
remove
clear
put
getKey
hash
expandTable
get
containsKey
getChainArray
size

Main class:
created table object of MyHashTable with key&value: Testing, MobilePhone
table iterated 10000 times and had various elements
Also, used different methods as put, get, remove, and clear, size
