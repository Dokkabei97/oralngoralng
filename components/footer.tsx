import React from 'react';
import {Box, Grid, Typography} from "@mui/material";
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select, {SelectChangeEvent} from '@mui/material/Select';

const Footer = () => {
    const [lang, setLang] = React.useState('');

    const handleChange = (event: SelectChangeEvent) => {
        setLang(event.target.value as string);
    };
    return (
        <Box sx={{flexGrow: 1}}>
            <Grid container spacing={2}>
                <Grid item xs={4}>
                    <Box m={2}>
                        <Typography
                            variant={"h6"}
                            sx={{fontWeight: "bold"}}
                            component={"div"}
                        >
                            올랑 올랑
                        </Typography>
                    </Box>
                </Grid>
                <Grid item xs={4}>
                    <Box m={2}>
                        <FormControl>
                            <InputLabel>Lang</InputLabel>
                            <Select
                                value={lang}
                                label="Lang"
                                onChange={handleChange}
                            >
                                <MenuItem value={1}>한국어</MenuItem>
                                <MenuItem value={2}>English</MenuItem>
                                <MenuItem value={3}>日本語</MenuItem>
                                <MenuItem value={4}>中國語</MenuItem>
                            </Select>
                        </FormControl>
                    </Box>
                </Grid>
            </Grid>
        </Box>
    );
};

export default Footer;