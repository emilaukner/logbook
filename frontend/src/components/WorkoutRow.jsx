import React from "react";
import { TableRow, TableCell } from "@mui/material";
import { Link } from "react-router-dom";


function WorkoutRow( { workout: {id, name, dateCreated, appUser} }) {

    return (
            <TableRow 
                key={id} 
                component={ Link }
                to={`/workouts/${id}/`}
                style={{ textDecoration: 'none' }} 
            >
                <TableCell component='div'>{id}</TableCell>
                <TableCell component='div'>{name}</TableCell>
                <TableCell component='div'>{dateCreated}</TableCell>
                <TableCell component='div'>{appUser.name}</TableCell>
            </TableRow>
    )
}

export default WorkoutRow;