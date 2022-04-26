import React from 'react';
import {styled, alpha} from '@mui/material/styles';
import Box from "@mui/material/Box";
import {Grid, InputBase, TextField} from "@mui/material";
import SearchIcon from '@mui/icons-material/Search';
import InputAdornment from '@mui/material/InputAdornment';

const SearchBar = () => {
    return (
        <Box sx={{flexGrow: 1}} bgcolor={'rgba(0, 117, 255, 0.72)'}>
            <Grid container justifyContent={"center"} alignItems={"center"}>
                <Grid item>
                    <Box m={2}>
                        <TextField
                            variant={"outlined"}
                            defaultValue={"여행지를 검색해 보세요"}
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
            </Grid>
        </Box>
    );
};

export default SearchBar;