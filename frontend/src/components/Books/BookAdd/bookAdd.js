import React from "react";
import {useState} from "react";
import {useNavigate} from "react-router-dom";
// import {useHistory} from "react-router-dom";

function BookAdd(props){
    // const history=useHistory();
    const navigate=useNavigate();
    const [formData, updateFormData] = useState({
        name:"",
        category:0,
        author:1,
        availableCopies:0
    });

    const onFormSubmit=(e)=>{
        e.preventDefault();
        const name=formData.name;
        const category=formData.category;
        const author=formData.author;
        const availableCopies=formData.availableCopies;

        props.onAddBook(name, category, author, availableCopies);
        // history.push("/books");
        navigate("/books");
    }
    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        });
    }

    return(
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Book name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               placeholder="Enter book name"
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="availableCopies">Available Copies</label>
                        <input type="text"
                               className="form-control"
                               id="availableCopies"
                               name="availableCopies"
                               placeholder="Enter available copies"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Category</label>
                        <select name="category" className="form-control" onChange={handleChange}>
                            {props.categories.map((term) =>
                                <option value={term}>{term}</option>
                            )}
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Authors</label>
                        <select name="author" className="form-control" onChange={handleChange}>
                            {props.authors.map((term) =>
                                <option value={term.id}>{term.name}</option>
                            )}
                        </select>
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    );

}

export default BookAdd;