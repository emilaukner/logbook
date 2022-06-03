import { TableContainer, Table, TableRow, TableCell, Paper, TableBody, TableHead } from "@mui/material";
import React from "react";
import WorkoutRow from "./WorkoutRow";

const ViewWorkouts = ({workouts}) => {
    
    return(
        <TableContainer component={Paper}>
        <Table component='div'>
            <TableHead component='div'>
                <TableRow component='div'>
                    <TableCell component='div'>ID</TableCell>
                    <TableCell component='div'>Workout Name</TableCell>
                    <TableCell component='div'>Date Created</TableCell>
                    <TableCell component='div'>Created By</TableCell>
                </TableRow>
            </TableHead>
            <TableBody component='div' >
                { workouts.map(workout => 
                    <WorkoutRow key={workout.id} workout={workout} />
                ) }
            </TableBody>
        </Table> 
    </TableContainer>
    );
}

export default ViewWorkouts;

