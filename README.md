# Version-Control-System
Custom VCS implementation

Maintaining a virtual file system and a version control system in Java.
The application supports a set of unix commands and is able to create, modify and delete files, as well as a set of vcs commands that will save the current state of the file system.

Design patterns used:
* Factory - operation creation automation (OperationFactory class)
* Singleton - where only one instance of a class was needed for simultaneous control of the same resource (OperationFactory classes, ErrorCodeManager, Context)
* Visitor - adding multiple operations without changing the structure of the VCS
