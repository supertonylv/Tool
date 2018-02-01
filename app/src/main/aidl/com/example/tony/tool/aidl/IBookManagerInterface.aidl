// IBookManagerInterface.aidl
package com.example.tony.tool.aidl;

import com.example.tony.tool.aidl.Book;

// Declare any non-default types here with import statements

 interface IBookManagerInterface {

     List<Book> getBooks();
     void addBook(in Book book);
}
