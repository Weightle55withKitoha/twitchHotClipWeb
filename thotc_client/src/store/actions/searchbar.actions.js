
export const SET_SEARCH_TEXT = "SearchBar/SET_SEARCH_TEXT";

export function setSearchBarText(event) {
    return {
        type : SET_SEARCH_TEXT,
        searchText : event.target.value
    };
}