import Header from "./Header";
import Footer from "./Footer";
import SearchBar from "./SearchBar";

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