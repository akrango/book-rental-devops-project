import axios from "../custom-axios/axios";

const BookService={
    fetchBooks:()=> axios.get("/books"),
    fetchCategories:()=> axios.get("/books/categories"),
    fetchAuthors:()=>{
        return axios.get("/authors");
    },
    fetchCountries:()=>{
        return axios.get("/countries");
    },
    deleteBook:(id)=>{
        return axios.delete(`/books/delete/${id}`);
    },
    addBook:(name, category, authorId, availableCopies)=>{
        return axios.post('/books/add', {
            "name":name,
            "category":category,
            "authorId":authorId,
            "availableCopies":availableCopies
        });
    },
    editBook:(id, name, category, authorId, availableCopies)=>{
        return axios.put(`/books/edit/${id}`,{
            "name":name,
            "category":category,
            "authorId":authorId,
            "availableCopies":availableCopies
        });
    },

    getBook:(id)=>{
        return axios.get(`/books/${id}`);
    },

    borrowBook:(id)=>{
        return axios.post(`/books/rent/${id}`)
    }
}
export default BookService;