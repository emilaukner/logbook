import React, { useEffect, useState } from "react";
import axios from "axios";
import ViewWorkouts from "../components/ViewWorkouts";
import CreateWorkoutButton from '../components/CreateWorkoutButton'
import { Container } from "@mui/material";


const Workouts = () => {
    const [workouts, setWorkouts] = useState([]);

    useEffect(() => {
        async function getData() {
            await axios
            .get('http://localhost:8080/api/workout/')
            .then(function (response) {
                setWorkouts(response.data)
            })
            .catch(function (error) {
                console.log(error)
            })
            .then(function () {
                
            }
        )}
        getData();
    }, []);

    return (
        <Container>
            <h1>Workouts</h1>
            {<ViewWorkouts workouts={workouts} />}
            <CreateWorkoutButton />
        </Container>
    );
}

export default Workouts;