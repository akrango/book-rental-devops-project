import './App.css';
import React, {Component} from "react";
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import Authors from "../Authors/authors";
import Countries from '../Countries/countries';
import Header from '../Header/header';
import BookService from "../../repository/bookRepository";
import Books from "../Books/BookList/books";
import BookAdd from "../Books/BookAdd/bookAdd";
import BookEdit from "../Books/BookEdit/bookEdit";
import Categories from "../Categories/categories";


class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            authors: [],
            books: [],
            categories: [],
            countries: [],
            selectedBook: {}
        }
    }

    render() {
        return (

            // <Router>
            <Router basename="/react">
                <Header />
                <main>
                    <div className="container">
                        <Routes>
                            <Route path={"/authors"} element={<Authors authors={this.state.authors} />} />
                            <Route path={"/categories"} element={<Categories categories={this.state.categories} />} />

                            <Route path={"/countries"} element={<Countries countries={this.state.countries} />} />
                            <Route path={"/books/add"} element={
                                <BookAdd authors={this.state.authors}
                                        categories={this.state.categories}
                                        onAddBook={this.addBook}/>}/>
                            <Route path={"/books/edit/:id"} element={
                                <BookEdit
                                    books={this.state.books}
                                    authors={this.state.authors}
                                    categories={this.state.categories}
                                    onEditBook={this.editBook}
                                    book={this.state.selectedBook}
                                />
                            }/>
                            <Route path={"/books"} element={
                                <Books books={this.state.books}
                                       onDelete={this.deleteBook}
                                   onEdit={this.getBook}
                                   onBorrow={this.borrowBook}
                                />}
                            />

                            <Route path={"/"} element={
                                <Books books={this.state.books}
                                       onDelete={this.deleteBook}
                                   onEdit={this.getBook}
                                   onBorrow={this.borrowBook}
                                />}
                            />

                            <Route path="*" element={<Navigate to="/books" />} />
                        </Routes>
                    </div>
                </main>
            </Router>
        );
    }

    componentDidMount() {
        this.fetchData()
    }

    fetchData = () => {
        this.loadAuthors();
        this.loadCountries();
        this.loadBooks();
        this.loadCategories();
    }

    loadAuthors = () => {
        BookService.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors: data.data
                })
            });
    }

    loadBooks = () => {
        BookService.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data
                })
            });
    }
    loadCategories = () => {
        BookService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            });
    }

    loadCountries = () => {
        BookService.fetchCountries()
            .then((data) => {
                this.setState({
                    countries: data.data
                })
            });
    }

    deleteBook = (id) => {
        BookService.deleteBook(id)
            .then(() => {
                this.loadBooks();
            });
    }

    addBook = (name, category, authorId, availableCopies) => {
        BookService.addBook(name, category, authorId, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

    getBook = (id) => {
        BookService.getBook(id)
            .then((data) => {
                this.setState({
                    selectedBook: data.data
                })
                console.log(data.data)
            })
    }

    editBook = (id, name, category, authorId, availableCopies) => {
        BookService.editBook(id, name, category, authorId, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

    borrowBook = (id) => {
        BookService.borrowBook(id)
            .then(() => {
                this.loadBooks();
            });
    }

}
export default App;
