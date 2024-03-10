## 序列化与反序列化
>When we stop and then reopen the program, the information about previously created objects is lost.

### Serialization and Deserialization
There are two processes to save and restore the state of objects between program launches: serialization and deserialization.

Serialization is a process that converts the state of an object into a stream of bytes. Objects are saved to some permanent storage for reconstruction at a later time.

Deserialization is the reverse process when the serialized byte form is used to reconstruct the actual object.

There are numerous ways to serialize Java objects into binary and text formats, for example, XML and JSON. The Java platform pays special attention to binary serialization and provides a default binary serialization protocol.

### Make a class serializable
To make a class serializable, it must implement the `Serializable` interface. This is a marker interface without methods. 

### Conclusion
Now you are familiar with the concept of serialization and considered a specific example.

Here are a few points to remember:
* a class to be serialized must implement the `Serializable` interface;
* it is a good practice to add the `serialVersionUID` field to be consistent with the versions during deserialization;
* you must specify in which place to save the state of objects using I/O Streams;
* use `writeObject()` and `readObject()` methods to serialize and deserialize any objects;
* don't forget to handle exceptions in real-world applications.

