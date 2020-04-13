package nameFormat

import (
	"fmt"
	"strings"
)

func FormatNames(names []map[string]string) string {
	if(len(names) == 0) {
		return ""
	}

	if (len(names) == 1) {
		return names[0]["name"]
	}

	var result []string
	for i := 0; i < len(names) - 1; i++ {
		result = append(result, names[i]["name"])
	}
	name_str := strings.Join(result, ", ")
	name_str += fmt.Sprintf(" & %s", names[len(names) - 1]["name"])
	return name_str
}