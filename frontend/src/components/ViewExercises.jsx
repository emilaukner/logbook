import React from 'react';
import { Paper, Table, TableRow, TableContainer, TableHead, TableBody, TableCell } from '@mui/material';
import ExerciseRow from './ExerciseRow';

const ViewExercises = ({exercises}) => {

    return (
        <TableContainer component={ Paper }>
            <Table>
            <TableHead>
                <TableRow>
                    <TableCell>Name</TableCell>
                    <TableCell>Sets</TableCell>
                    <TableCell>RepsPerSet</TableCell>
                    <TableCell>Weight (kg) </TableCell>
                    <TableCell>Rest Time (s) </TableCell>
                </TableRow>
            </TableHead>
            <TableBody>
                    { exercises.map(exercise =>
                        <ExerciseRow key={exercise.id} exercise={exercise} />
                    ) }
            </TableBody>
            </Table>
        </TableContainer>
    );
}

export default ViewExercises;