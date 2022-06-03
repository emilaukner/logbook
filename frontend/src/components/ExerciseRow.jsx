import React from 'react';
import { TableRow, TableCell } from '@mui/material';

function ExerciseRow ({ exercise: {id, name, sets, repsPerSet, weight, restTime} }) {


    return (
            <TableRow key={id}>
                <TableCell>{name}</TableCell>
                <TableCell>{sets}</TableCell>
                <TableCell>{repsPerSet}</TableCell>
                <TableCell>{weight}</TableCell>
                <TableCell>{restTime}</TableCell>
            </TableRow>

    );
} 

export default ExerciseRow;