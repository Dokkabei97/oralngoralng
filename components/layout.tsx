import type {NextPage} from 'next'
import Header from "./header";
import Footer from "./footer";
import SearchBar from "./searchbar";

const Layout = ({children}) => {
    return (
        <>
            <Header/>
            <SearchBar/>
            <main>{children}</main>
            <Footer/>
        </>
    );
};

export default Layout;