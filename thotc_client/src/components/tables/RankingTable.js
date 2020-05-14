import React, { useState, useEffect } from "react";
import { makeStyles } from "@material-ui/core/styles";
import {
  Paper,
  Tabs,
  Tab,
  Grid,
} from "@material-ui/core";
import TableLower from "./LowerTable";
import TableToolbar from "./TableToolbar";

import ChatIcon from "@material-ui/icons/Chat";
import EmojiPeopleIcon from "@material-ui/icons/EmojiPeople";
import StarIcon from "@material-ui/icons/Star";
import PeopleIcon from "@material-ui/icons/People";
import TimerIcon from "@material-ui/icons/Timer";
import UpdateIcon from "@material-ui/icons/Update";

import * as Actions from "../../store/actions";
import { useDispatch, useSelector } from "react-redux";

function a11yProps(index) {
  return {
    id: `full-width-tab-${index}`,
    "aria-controls": `full-width-tabpanel-${index}`,
  };
}

function IconStyle() {
  return {
    chatting: {
      color: "#e53e3e",
      "&:hover": {
        color: "#ffffff",
      },
    },
    emojipeople: {
      color: "#d69e2e",
    },
    star: {
      color: "#805ad5",
    },
    people: {
      color: "#dd6b20",
    },
    timer: {
      color: "#38a169",
    },
    update: {
      color: "#059bff",
    },
  };
}

const createGrid = (tabLabel, tabIcon) => {
  return (
    <Grid container direction="row" justify="center" >
      <Grid item>{tabIcon}</Grid>
      <Grid item style={{ marginLeft: "10px", paddingBottom: "6px" }}>
        {tabLabel}
      </Grid>
    </Grid>
  );
};

const RankingTable = () => {
  const [value, setValue] = useState(2);
  const bottomColors = ["#e53e3e", "#d69e2e", "#805ad5", "#dd6b20", "#38a169"];
  const [sstyle, setSstyle] = useState([0, 0, 0, 0, 0]);
  const style2 = [
    { background: "#ffffff", color: "#000000" },
    { background: "#e53e3e", color: "#ffffff" },
    { background: "#d69e2e", color: "#ffffff" },
    { background: "#805ad5", color: "#ffffff" },
    { background: "#dd6b20", color: "#ffffff" },
    { background: "#38a169", color: "#ffffff" },
    { background: "#059bff", color: "#ffffff" },
  ];

  const iconclasses = makeStyles(IconStyle)();

  const tabsNames = [
    {
      Label: "실시간 채팅속도",
      tabIcon: <ChatIcon className={iconclasses.chatting} fontSize="small" />,
    },
    {
      Label: "실청자",
      tabIcon: (
        <EmojiPeopleIcon className={iconclasses.emojipeople} fontSize="small" />
      ),
    },
    {
      Label: "평청자",
      tabIcon: <StarIcon className={iconclasses.star} fontSize="small" />,
    },
    {
      Label: "팔로워",
      tabIcon: <PeopleIcon className={iconclasses.people} fontSize="small" />,
    },
    {
      Label: "방송시간",
      tabIcon: <TimerIcon className={iconclasses.timer} fontSize="small" />,
    },
    {
      Label: "마지막방송 시간",
      tabIcon: (
        <UpdateIcon
          className={iconclasses.update}
          color="inherit"
          fontSize="small"
        />
      ),
    },
  ];

  const dispatch = useDispatch();
  const rows = useSelector((state) => state.rankingTable.responsedata);

  useEffect(() => {
    dispatch(Actions.getRankingTableDataAPI());
  }, []);

  const mouseOver = (index) => {
    const tmp = sstyle.slice();
    tmp[index] = index + 1;
    setSstyle(tmp);
  };

  const mouseLeave = (index) => {
    const tmp = sstyle.slice();
    tmp[index] = 0;
    setSstyle(tmp);
  };

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <Paper style={{ marginTop: 50 }} elevation={7}>
        <TableToolbar />    
              <Tabs
                value={value}
                onChange={handleChange}
                TabIndicatorProps={{
                  style: {
                    background: bottomColors[value - 2],
                    color: "white",
                  },
                }}
                variant="fullWidth"
              >
                <Tab style={{ width: "5px" }} label="순위" disabled />
              
                  <Tab label="스트리머" disabled />
                  {tabsNames.map((tabsName, index) => (
                    <Tab
                      key={index}
                      label={createGrid(tabsName.Label, tabsName.tabIcon)}
                      onMouseOver={() => mouseOver(index)}
                      onMouseLeave={() => mouseLeave(index)}
                      style={style2[sstyle[index]]}
                      // {...a11yProps(index)}
                    />
                  ))}             
              </Tabs>    
          <TableLower rowCells={rows}></TableLower>
        
    </Paper>
  );
};

export default RankingTable;
