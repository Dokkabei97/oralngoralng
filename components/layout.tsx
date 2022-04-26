import type {NextPage} from 'next'
import Header from "./header";
import Footer from "./footer";
import SearchBar from "./searchbar";
import {Container} from "@mui/material";

const Layout = ({children}) => {
    return (
        <>
            <Header/>
            <main>
                <SearchBar/>
                {children}
            </main>
            <Footer/>
        </>
    );
};

export default Layout;