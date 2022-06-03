import React from "react";
import {Typography} from '@mui/material';

function SingleWorkoutHeader({ workout: { name, dateCreated }, userName }) {
    return (
    <>
    <h1> { name } </h1>
    {<Typography> Date Created: { dateCreated }</Typography>}
    {<Typography> Created By: { userName } </Typography>}
    </>

)
}

export default SingleWorkoutHeader;