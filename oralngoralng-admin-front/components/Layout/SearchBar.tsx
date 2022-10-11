import React from 'react';
import Box from "@mui/material/Box";
import {Grid, TextField} from "@mui/material";
import SearchIcon from '@mui/icons-material/Search';
import InputAdornment from '@mui/material/InputAdornment';
import styles from './_searchbar.module.scss';

const SearchBar = () => {
    return (
        <Box className={styles.box}>
            <Grid container justifyContent={"center"} alignItems={"center"}>
                <Grid item xs={3.5}></Grid>
                <Grid item xs={5}>
                    <Box m={4}>
                        <TextField
                            className={styles.textField}
                            fullWidth
                            variant={"filled"}
                            label={"여행지를 검색해 보세요"}

                            InputProps={{
                                startAdornment: (
                                    <InputAdornment position="start">
                                        <SearchIcon/>
                                    </InputAdornment>
                                )
                            }}
                        />
                    </Box>
                </Grid>
                <Grid item xs={3.5}></Grid>
            </Grid>
        </Box>
    );
};

export default SearchBar;