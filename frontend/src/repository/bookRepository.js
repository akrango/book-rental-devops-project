// import axios from "../custom-axios/axios";

// const BookService={
//     fetchBooks:()=> axios.get("/books"),
//     fetchCategories:()=> axios.get("/books/categories"),
//     fetchAuthors:()=>{
//         return axios.get("/authors");
//     },
//     fetchCountries:()=>{
//         return axios.get("/countries");
//     },
//     deleteBook:(id)=>{
//         return axios.delete(`/books/delete/${id}`);
//     },
//     addBook:(name, category, authorId, availableCopies)=>{
//         return axios.post('/books/add', {
//             "name":name,
//             "category":category,
//             "authorId":authorId,
//             "availableCopies":availableCopies
//         });
//     },
//     editBook:(id, name, category, authorId, availableCopies)=>{
//         return axios.put(`/books/edit/${id}`,{
//             "name":name,
//             "category":category,
//             "authorId":authorId,
//             "availableCopies":availableCopies
//         });
//     },

//     getBook:(id)=>{
//         return axios.get(`/books/${id}`);
//     },

//     borrowBook:(id)=>{
//         return axios.post(`/books/rent/${id}`)
//     }
// }
// export default BookService;

import { primaryInstance, fallbackInstance } from "../custom-axios/axios";

const BookService = {
    fetchBooks: () => primaryInstance.get("/books").catch(() => fallbackInstance.get("/books")),
    
    fetchCategories: () => primaryInstance.get("/books/categories").catch(() => fallbackInstance.get("/books/categories")),
    
    fetchAuthors: () => primaryInstance.get("/authors").catch(() => fallbackInstance.get("/authors")),
    
    fetchCountries: () => primaryInstance.get("/countries").catch(() => fallbackInstance.get("/countries")),
    
    deleteBook: (id) => primaryInstance.delete(`/books/delete/${id}`).catch(() => fallbackInstance.delete(`/books/delete/${id}`)),
    
    addBook: (name, category, authorId, availableCopies) => primaryInstance.post('/books/add', {
        "name": name,
        "category": category,
        "authorId": authorId,
        "availableCopies": availableCopies
    }).catch(() => fallbackInstance.post('/books/add', {
        "name": name,
        "category": category,
        "authorId": authorId,
        "availableCopies": availableCopies
    })),
    
    editBook: (id, name, category, authorId, availableCopies) => primaryInstance.put(`/books/edit/${id}`, {
        "name": name,
        "category": category,
        "authorId": authorId,
        "availableCopies": availableCopies
    }).catch(() => fallbackInstance.put(`/books/edit/${id}`, {
        "name": name,
        "category": category,
        "authorId": authorId,
        "availableCopies": availableCopies
    })),
    
    getBook: (id) => primaryInstance.get(`/books/${id}`).catch(() => fallbackInstance.get(`/books/${id}`)),
    
    borrowBook: (id) => primaryInstance.post(`/books/rent/${id}`).catch(() => fallbackInstance.post(`/books/rent/${id}`))
};

export default BookService;
