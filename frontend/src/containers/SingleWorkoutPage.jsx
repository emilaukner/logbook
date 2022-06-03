import { Container } from "@mui/system";
import React, { useEffect, useState } from "react";
import ViewExercises from "../components/ViewExercises";
import axios from "axios";
import { useParams } from "react-router-dom";
import SingleWorkoutHeader from "../components/SingleWorkoutHeader";
import { Paper } from '@mui/material';

const SingleWorkoutPage = () => {
    const [workout, setWorkout] = useState([]);
    const [user, setUser] = useState([]);
    const [exercises, setExercises] = useState([]);
    const { id } = useParams();

    useEffect(() => {
        function getData() {
            axios
            .get(`http://localhost:8080/api/workout/${id}`)
            .then(function (response) {
                setWorkout(response.data)
                setUser(response.data.appUser)
                setExercises(response.data.exerciseList)
            })
            .catch(function (error) {
                console.log(error)
            })
        }
        getData();
    }, [id]);

    return (
        <Container component={ Paper }>
            <SingleWorkoutHeader workout={workout} userName={user.name} />
            {<ViewExercises exercises={ exercises } />}
        </Container>
    );
}

export default SingleWorkoutPage;