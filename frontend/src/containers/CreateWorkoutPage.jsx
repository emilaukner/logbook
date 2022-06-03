import React from 'react';
import CreateWorkout from '../components/CreateWorkout'
import { Container } from '@mui/material'

const CreateWorkoutPage = () => {
    return (
        <Container>
            <h1>Create Workout</h1>
            <CreateWorkout />
        </Container>
    );
}

export default CreateWorkoutPage;