import React from "react";
import {Link} from "react-router-dom";

const bookTerm = (props) => {
    console.log(props.term.id)
    return (
        <tr>
            <td>{props.term.name}</td>
            <td>{props.term.category}</td>
            <td>{props.term.author.name}</td>
            <td>{props.term.availableCopies}</td>
            <td className={"text-right"}>
                <a title={"Delete"} className={"btn btn-danger"}
                   onClick={() => props.onDelete(props.term.id)}>
                    Delete
                </a>
                <Link className={"btn btn-info ml-2"}
                      onClick={() => props.onEdit(props.term.id)}
                      to={`/books/edit/${props.term.id}`}>
                    Edit
                </Link>

                {props.term.availableCopies > 0 && (
                    <a title={"Borrow"} className={"btn btn-secondary ml-2"}
                       onClick={() => props.onBorrow(props.term.id)}>
                        Mark as Taken
                    </a>
                )}
            </td>
        </tr>
    );
}

export default bookTerm;