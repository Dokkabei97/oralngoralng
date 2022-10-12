import React from 'react';
import {Box, Grid, Typography} from "@mui/material";
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select, {SelectChangeEvent} from '@mui/material/Select';
import styles from './_footer.module.scss';

const Footer = () => {
    const [lang, setLang] = React.useState('1');

    const handleChange = (event: SelectChangeEvent) => {
        setLang(event.target.value as string);
    };
    return (
        <Grid container spacing={2}>
            <Grid item xs={3}>
            </Grid>
            <Grid item xs={3}>
                <Box m={2}>
                    <Typography
                        className={styles.typography}
                    >
                        올랑 올랑
                    </Typography>
                </Box>
            </Grid>
            <Grid item xs={3}>
                <Box m={2}>
                    <FormControl
                        className={styles.fromControl}
                    >
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
            <Grid item xs={3}>
            </Grid>
        </Grid>
    );
};

export default Footer;