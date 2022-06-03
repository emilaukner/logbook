import { Container, TextField, Paper, Button } from "@mui/material";
import React, {useState} from "react";
import axios from "axios";

const CreateUser = () => {
    const [email, setEmail] = useState('NoEmail'); //NoEmail and NoName just for test purposes
    const [name, setName] = useState('NoName');



    const createUser = () => {
        axios.post('http://localhost:8080/api/user', {
            email,
            name
        })
        .then(function (response) {
            console.log("HTTPStatus:" + response.status)
            console.log("user created")
        }).catch(function (error) {
            console.log(error.response.data)
            console.log(error.response.data.message)
        });
    }

    return (
        <Container>
            <Paper>
                <TextField label="E-mail" value={email} onChange={(e) => (setEmail(e.target.value))}/>
                <TextField label="Name" value={name} onChange={(e) => (setName(e.target.value))}/>
                <Button onClick={createUser}>
                Post User
                </Button>
            </Paper>
        </Container>
    );
}

export default CreateUser;