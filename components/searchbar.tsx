import React from 'react';
import {styled, alpha} from '@mui/material/styles';
import Box from "@mui/material/Box";
import {Grid, InputBase, OutlinedInputProps, TextField, TextFieldProps} from "@mui/material";
import SearchIcon from '@mui/icons-material/Search';
import InputAdornment from '@mui/material/InputAdornment';

const CustomTextField = styled((props: TextFieldProps) => (
    <TextField
        InputProps={{ disableUnderline: true } as Partial<OutlinedInputProps>}
        {...props}
    />
    ))(({ theme}) => ({
    '& .MuiFilledInput-root': {
        borderRadius: 4,
        backgroundColor: 'white',
    },
    '& .MuiInputBase-root': {
        backgroundColor: 'white',
    },
    '& .MuiInputBase-formControl': {
        backgroundColor: 'white',
    }
}));

const SearchBar = () => {
    return (
        <Box sx={{flexGrow: 1}} bgcolor={'rgba(0, 117, 255, 0.72)'}>
            <Grid container justifyContent={"center"} alignItems={"center"}>
                <Grid item xs={5}>
                    <Box m={4}>
                        <CustomTextField
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
            </Grid>
        </Box>
    );
};

export default SearchBar;