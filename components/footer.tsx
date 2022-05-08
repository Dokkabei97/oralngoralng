import React from 'react';
import {Typography} from "@mui/material";

const Footer = () => {
    return (
        <div>
            <Typography
                variant={"h6"}
                sx={{ fontWeight: "bold" }}
                component={"div"}
            >
                올랑 올랑
            </Typography>
        </div>
    );
};

export default Footer;