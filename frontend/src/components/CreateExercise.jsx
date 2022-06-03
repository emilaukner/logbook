import { TextField, Button } from '@mui/material';
import { Container, Paper } from '@mui/system';
import React from 'react';
import axios from 'axios';

const CreateExercise = (props) => {
    const [workoutId, setWorkoutId] = React.useState(0);
    const [exerciseName, setExerciseName] = React.useState('');
    const [repsPerSet, setRepsPerSet] = React.useState(0);
    const [restTime, setRestTime] = React.useState(0);
    const [sets, setSets] = React.useState(0);
    const [weight, setWeight] = React.useState(0.0);

    const sendData = async () => {
        await
        axios.put(`http://localhost:8080/api/workout/${workoutId}`, {},  {params: {
            name: exerciseName,
            sets,
            repsPerSet,
            weight,
            restTime
        }})
        .then(function (response) {
            console.log("HTTPStatus:" + response.status)
            console.log("Exercise created")
        }).catch(function (error) {
            console.log(error.response.data)
            console.log(error.response.data.message)
        });
    }

    React.useEffect(() => {
        setWorkoutId(props.workoutId)
        console.log('workoutId changed from ' + workoutId +'to  ' + props.workoutId)
    },[props.workoutId])

    return (
        <Container component={ Paper }>
            <TextField label="Name" value={exerciseName} onChange={(e) => (setExerciseName(e.target.value))}/>
            <TextField label="Repetitons Per Set" value={repsPerSet} onChange={(e) => (setRepsPerSet(e.target.value))}/>
            <TextField label="Rest Time" value={restTime} onChange={(e) => (setRestTime(e.target.value))}/>
            <TextField label="Sets" value={sets} onChange={(e) => (setSets(e.target.value))}/>
            <TextField label="Weight" value={weight} onChange={(e) => (setWeight(e.target.value))}/>
            <Button onClick={ sendData }>Post exercise</Button>
        </Container>
    );
}

export default CreateExercise;