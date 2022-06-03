import { Container, TextField, Paper, Button } from "@mui/material";
import React from "react";
import axios from "axios";

const CreateWorkout = () => {
    const [name, setName] = React.useState('');
    const [workoutId, setWorkoutId] = React.useState(0);
    
    function createWorkout() {
        axios.post('http://localhost:8080/api/workout', {},
        { params: {
            name, userName: 'Emil', userEmail:'emil@test.com'
        }}).then(function (response) {
            console.log(response)
            setWorkoutId(response.data)
        }).catch(function (error) {
            console.log(error)
        });
    }
    return (
        <Container>
            <Paper>
                <TextField value={ name } label="Name"  onChange={ (e) => (setName(e.target.value)) }/>
            <Button onClick={ createWorkout }>
                Post Data
            </Button>
            </Paper>
        </Container>
    );
}

export default CreateWorkout;